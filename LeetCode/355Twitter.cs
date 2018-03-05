public class Twitter {
    Dictionary<int, List<int>> userPosts = new Dictionary<int, List<int>>();
    Dictionary<int, HashSet<int>> userFollows = new Dictionary<int, HashSet<int>>();
    List<int> postOrder = new List<int>();
    
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    private int AddTweet(int tweetId){
        postOrder.Add(tweetId);       
        return postOrder.Count;
    }
    
    /** Compose a new tweet. */
    public void PostTweet(int userId, int tweetId) {
        List<int> list;
        if (!userPosts.TryGetValue(userId, out list)) list = new List<int>();
        list.Add(AddTweet(tweetId));
        userPosts[userId] = list;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public IList<int> GetNewsFeed(int userId) {
        List<int> posts;
        if (!userPosts.TryGetValue(userId, out posts)) posts = new List<int>();        
        
        List<int> ret = new List<int>(posts);
        HashSet<int> follows;
        if (userFollows.TryGetValue(userId, out follows)) {
            foreach(int id in follows){
                List<int> list;
                if (userPosts.TryGetValue(id, out list)){
                    ret.AddRange(list);
                }
            }
        }
        
        var sorted = ret.OrderByDescending(x => x).Take(10).Select(x => postOrder[x-1]).ToList();        
        return sorted;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void Follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        
        HashSet<int> follows;
        if (!userFollows.TryGetValue(followerId, out follows)) follows = new HashSet<int>();
        follows.Add(followeeId);        
        userFollows[followerId]=follows;
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void Unfollow(int followerId, int followeeId) {
        HashSet<int> follows;
        if (userFollows.TryGetValue(followerId, out follows)) {
            if (follows.Contains(followeeId)){
                follows.Remove(followeeId);        
                userFollows[followerId]=follows;  
            }
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.PostTweet(userId,tweetId);
 * IList<int> param_2 = obj.GetNewsFeed(userId);
 * obj.Follow(followerId,followeeId);
 * obj.Unfollow(followerId,followeeId);
 */
