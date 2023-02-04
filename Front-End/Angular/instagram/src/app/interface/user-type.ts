export interface userType  {
    userId: string;
    userName: string;
    followersCount: number;
    followingCount: number;
    numberOfPosts: number;
    bio: string;
    profilePicture: {
        type: number,
        data: string;
    }
}