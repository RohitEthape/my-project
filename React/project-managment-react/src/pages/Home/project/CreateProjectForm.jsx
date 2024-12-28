import { useForm } from "react-hook-form";
import { Form, FormControl, FormField, FormItem, FormMessage } from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import { DialogClose } from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { tags } from "../projectList/projectList.jsx"; 
import { Cross1Icon } from "@radix-ui/react-icons";

const CreateProjectForm = () => {  

    const form = useForm({
        defaultValues: {
            name: "",
            description: "",
            category: "",
            tags: [],
        },
    });

    const handleTagsChange=(newValue)=>{
        const currentTags=form.getValues("tags");

        const updatedTags=currentTags.includes(newValue)?
        currentTags.filter(tag=>tag!==newValue):[...currentTags,newValue];
        form.setValue("tags",updatedTags);
    }    
   

    const onSubmit = (data) => {
        console.log("create project data", data);
    };

    const projectLimitReached = false; // Replace with actual logic to check project limit

    return (
        <div>
            <Form {...form}>
                <form className="space-y-5" onSubmit={form.handleSubmit(onSubmit)}>
                    
                    <FormField
                        control={form.control}
                        name="name"
                        render={({ field }) => (
                            <FormItem>
                                <label htmlFor="name" className="block">Project Name</label>
                                <FormControl>
                                    <Input
                                        {...field}
                                        id="name"
                                        type="text"
                                        className="border w-full border-grey-700 py-5 px-5"
                                        placeholder="Project name..."
                                    />
                                </FormControl>
                                <FormMessage />
                            </FormItem>
                        )}
                    />

                    <FormField
                        control={form.control}
                        name="description"
                        render={({ field }) => (
                            <FormItem>
                                <label htmlFor="description" className="block">Project Description</label>
                                <FormControl>
                                    <Input
                                        {...field}
                                        id="description"
                                        type="text"
                                        className="border w-full border-grey-700 py-5 px-5"
                                        placeholder="Project description..."
                                    />
                                </FormControl>
                                <FormMessage />
                            </FormItem>
                        )}
                    />

                    <FormField
                        control={form.control}
                        name="category"
                        render={({ field }) => (
                            <FormItem>
                                <label htmlFor="category" className="block">Category</label>
                                <FormControl>
                                    <Select
                                        value={field.value}
                                        onValueChange={field.onChange}
                                    >
                                        <SelectTrigger>
                                            <SelectValue placeholder="Select category" />
                                        </SelectTrigger>
                                        <SelectContent>
                                            <SelectItem value="fullstack">Full Stack</SelectItem>
                                            <SelectItem value="frontend">Frontend</SelectItem>
                                            <SelectItem value="backend">Backend</SelectItem>
                                        </SelectContent>
                                    </Select>
                                </FormControl>
                                <FormMessage />
                            </FormItem>
                        )}
                    />

                    <FormField
                        control={form.control}
                        name="tags"
                        render={({ field }) => (
                            <FormItem>
                                <FormControl>
                                    <Select
                                       
                                        onValueChange={(value) => 
                                            handleTagsChange(value)}
                                    >
                                        <SelectTrigger className="w-full">
                                            <SelectValue placeholder="Select tags" />
                                        </SelectTrigger>
                                        <SelectContent>
                                          {tags.map((item)=>  <SelectItem key={item} value={item}>{item}</SelectItem>)}
                                           
                                        </SelectContent>
                                    </Select>
                                </FormControl>
                                <div className="flex gap-1 flex-wrap">

                                   {field.value.map((item)=> <div key={item} onClick={()=>
                                   handleTagsChange(item)} className="cursor-pointer flex
                                    rounded-full item-center border gap-2 px-4 py-1">

                                    <span className="text-sm">{item}</span>
                                    <Cross1Icon className="h-3 w-3"/>
                                    </div>)}
                                </div >
                               
                                <FormMessage />
                            </FormItem>
                        )}
                    />

                    <DialogClose>
                        
                        {false ? (
                            <div>
                                <p>You can create only 3 projects with the free plan. Please upgrade your plan to create more projects.</p>
                            </div>
                        ) : (
                            <Button type="submit" className="w-full mt-5">
                                Create Project
                            </Button>
                        )}
                    </DialogClose>
                </form>
            </Form>
        </div>
    );
};

export default CreateProjectForm;
