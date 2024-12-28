import { Avatar, AvatarFallback } from "@/components/ui/avatar";

const UserList = () => {
    const userName = "Ram"; // You can change this to null or empty string to test "unassignee"

    return (
        <div className="space-y-2">
            <div className="border rounded-md">
                <p className="py-2 px-3">{userName || "Unassignee"}</p>
            </div>
           { [1,1,1,1].map((item)=> <div key={item} className="py-2 group hover:bg-slate-800 cursor-pointer flex items-center 
                space-x-4 rounded-md border px-4">
                <Avatar>
                    <AvatarFallback>
                        Roh
                    </AvatarFallback>
                </Avatar>
                <div className="space-y-1">
                    <p className="text-sm font-medium leading-none">Code Project</p>
                    <p className="text-sm text-muted-foregrounded">@codeproject</p>
                </div>
            </div>)  }
        </div>
    );
};

export default UserList;
