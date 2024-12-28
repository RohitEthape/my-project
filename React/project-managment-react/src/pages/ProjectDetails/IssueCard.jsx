import { Avatar, AvatarFallback } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { DropdownMenu, DropdownMenuTrigger, DropdownMenuContent, DropdownMenuItem } from "@/components/ui/dropdown-menu";
import { DotsVerticalIcon, PersonIcon } from "@radix-ui/react-icons";
import UserList from "./UserList";
import { useNavigate } from "react-router-dom";

const IssueCard = () => {
    const navigate = useNavigate();
    return (
        <Card className="rounded-md py-1 pb-2">
            <CardHeader className="py-0 pb-1">
                <div className="flex justify-between items-center">
                    <CardTitle className="cursor-pointer" onClick={()=>navigate("/project/3/issue/16")}>
                        Create Navbar
                    </CardTitle>
                    <DropdownMenu>
                        <DropdownMenuTrigger>
                            <button className="rounded-full" size="icon" variant="ghost">
                                <DotsVerticalIcon />
                            </button>
                        </DropdownMenuTrigger>
                        <DropdownMenuContent>
                           <UserList/>
                        </DropdownMenuContent>
                    </DropdownMenu>
                </div>
            </CardHeader>
            <CardContent className="py-1">
                <div className="flex items-center justify-between">
                    <p>FBP - {1}</p>
                    <DropdownMenu>
                        <DropdownMenuTrigger>
                            <Button size="icon" className="bg-gray-900 hover:text-black text-white rounded-full">
                                <Avatar>
                                    <AvatarFallback>
                                        <PersonIcon />
                                    </AvatarFallback>
                                </Avatar>
                            </Button>
                        </DropdownMenuTrigger>
                        <DropdownMenuContent>
                            <DropdownMenuItem>
                                Profile
                            </DropdownMenuItem>
                            <DropdownMenuItem>
                                Settings
                            </DropdownMenuItem>
                            <DropdownMenuItem>
                                Logout
                            </DropdownMenuItem>
                        </DropdownMenuContent>
                    </DropdownMenu>
                </div>
            </CardContent>
        </Card>
    );
};

export default IssueCard;
