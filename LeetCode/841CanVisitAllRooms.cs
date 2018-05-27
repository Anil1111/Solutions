public class Solution {
    public bool CanVisitAllRooms(IList<IList<int>> rooms) {       
        var set = new HashSet<int>();
        var stack = new Stack<int>();
        stack.Push(0);
        while(stack.Count>0){
            var room = stack.Pop();
            set.Add(room);
            var keys = rooms[room];
            foreach(var key in keys){
                if (!set.Contains(key)){
                    stack.Push(key);
                }
            }
        }
        return set.Count == rooms.Count;
    }
}
