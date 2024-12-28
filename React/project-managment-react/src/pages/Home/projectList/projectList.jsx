import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group";
import { MagnifyingGlassIcon, MixerHorizontalIcon } from "@radix-ui/react-icons";
import { ScrollArea } from "@radix-ui/react-scroll-area";
import React, { useState } from "react";
import ProjectCard from "../project/projectCard";

export const tags = [
    "All",
    "react",
    "nextjs",
    "spring boot",
    "mysql",
    "mongodb",
    "angular",
    "python",
    "flask",
    "django"
];

const ProjectList = () => {
    const [keyWord, setKeyword] = useState("");

    const handleFilterChange = (section, value) => {
        console.log("value", value, section);
    };

    const handleSearchChange = (e) => {
        setKeyword(e.target.value);
    };

    return (
        <div className="relative px-5 lg:px-0 lg:flex gap-5 py-5">
            <section className="filterSection lg:w-[20rem] flex-shrink-0">
                <Card className="p-5 sticky top-10">
                    <div className="flex justify-between">
                        <p className="text-xl -tracking-wider">Filters</p>
                        <Button variant="ghost" size="icon" aria-label="Toggle filters">
                            <MixerHorizontalIcon />
                        </Button>
                    </div>
                    <CardContent className="mt-5">
                        <ScrollArea className="space-y-7" style={{ height: '70vh', overflowY: 'auto' }}>
                            <div>
                                <h1 className="pb-3 text-gray-400 border-b">Category</h1>
                                <div className="pt-5">
                                    <RadioGroup className="space-y-3" defaultValue="all" onValueChange={(value) => handleFilterChange("category", value)}>
                                        {["all", "Fullstack", "Frontend", "Backend"].map((category) => (
                                            <div key={category} className="flex items-center gap-2">
                                                <RadioGroupItem value={category} id={`category-${category}`} />
                                                <label htmlFor={`category-${category}`}>{category}</label>
                                            </div>
                                        ))}
                                    </RadioGroup>
                                </div>
                            </div>

                            <div className="pt-9">
                                <h1 className="pb-3 text-gray-400 border-b">Tag</h1>
                                <div className="pt-5">
                                    <RadioGroup className="space-y-3" defaultValue="All" onValueChange={(value) => handleFilterChange("tag", value)}>
                                        {tags.map((item) => (
                                            <div key={item} className="flex items-center gap-2">
                                                <RadioGroupItem value={item} id={`tag-${item}`} />
                                                <label htmlFor={`tag-${item}`}>{item}</label>
                                            </div>
                                        ))}
                                    </RadioGroup>
                                </div>
                            </div>
                        </ScrollArea>
                    </CardContent>
                </Card>
            </section>
            <section className="projectListSection flex-1 lg:w-[48rem]">
                <div className="flex gap-2 items-center pb-5 justify-between">
                    <div className="relative p-0 w-full">
                        <Input
                            onChange={handleSearchChange}
                            placeholder="Search projects"
                            className="px-9"
                        />
                        <MagnifyingGlassIcon className="absolute top-3 left-4" />
                    </div>
                </div>
                <div>
                    <div className="space-y-5 min-h-[74vh]">
                        {keyWord ? [1, 1, 1].map((item) => <ProjectCard key={item}/>) :
                            [1, 1, 1, 1,1].map((item) => <ProjectCard key={item}/>)
                        }
                    </div>
                </div>
            </section>
        </div>
    );
};

export default ProjectList;
