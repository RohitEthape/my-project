import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { Dialog, DialogClose, DialogContent, DialogHeader, DialogTrigger } from "@/components/ui/dialog";
import { PlusIcon } from "@radix-ui/react-icons";
import { ScrollArea } from "@/components/ui/scroll-area";
import InviteUserForm from "./InviteUserForm";
import IssueList from "./IssueList";
import ChatBot from "./ChatBot";

const ProjectDetails = () => {

    const handleProjectInvitation = ()=>{

    }
    return (
        <>
            <div className="mt-5 lg:px-10">
                <div className="lg:flex gap-5 justify-between pb-4">
                    <ScrollArea className="h-96 lg:w-[69%] pr-2"> {/* Set height for scrolling */}
                        <div className="text-gray-400 pb-10 w-full">
                            <h1 className="text-lg font-semibold pb-5">Create E-commerce Website Using React</h1>
                        <div className="space-y-5 pb-10 text-sm">
                            <p className="w-full md:max-w-lg lg:max-w-xl text-sm">
                                suirfhakwjdnf,kagrtkjawdf,kjgaljkrbf,KWJGDFHAWRV SMZDHBK UHAKIURFH UHKIWUE FwurgflaeiurhLWEUIHAWI
                            </p>
                            {/* You might want to add more content here to make scrolling more apparent */}
                       <div className="flex">
                        <p className="w-36"> Project Lead :</p>
                        <p>Roh</p>
                       </div>
                       <div className="flex">
                        <p className="w-36">Members :</p>
                        <div className="flex items-center gap-2">

                       {[1,2,3].map((item)=><Avatar className="cursor-pointer" key={item}>
                        <AvatarFallback>Z</AvatarFallback>
                       </Avatar>)}

                       <Dialog>
                            <DialogTrigger>
                                <DialogClose>
                                    <Button size="sm" variant="outline" onClick={handleProjectInvitation} className="ml-2">
                                        <span>invite</span>
                                        <PlusIcon className="w-3 h-3"/>
                                    </Button>
                                </DialogClose>
                            </DialogTrigger>
                            <DialogContent>
                                <DialogHeader>Invite UserS</DialogHeader>
                               <InviteUserForm/>
                            </DialogContent>
                        </Dialog>
                       </div>
                        </div>
                       
                      
                        <div className="flex">
                        <p className="w-36"> Category :</p>
                        <p>Fullstack</p>
                       </div>

                       <div className="flex">
                        <p className="w-36"> Project Lead :</p>
                        <Badge>Roh</Badge>

                       </div>

                        </div>

                        <section>
                            <p className="space-py-5 pb-10 text-sm">TASKS</p>
                            <div className="lg:flex md:flex gap-3 justify-between py-5">

                                <IssueList status="pending" tital="Todo list"/>
                                <IssueList status="in_progress" tital="In progress"/>
                                <IssueList status="Done" tital="Done"/>

                                 
                            </div>
                        </section>
                        </div>
                       
                    </ScrollArea>
                    <div className="lg:w-[30%] rounded-md sticky right-5 top-10">
                        <ChatBot/>  
                    </div>
                </div>
            </div>
        </>
    );
};

export default ProjectDetails;
