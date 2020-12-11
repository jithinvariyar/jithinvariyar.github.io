public class PainJob {
    public static int getBucketCount(double width , double height , double areaPerBucket , int extraBuckets){
        if(width <= 0 || height <=0 || areaPerBucket <= 0 || extraBuckets < 0){
            return -1;
        }
        double wallArea = width * height;
        int totalBuckets = (int) (Math.ceil(wallArea / areaPerBucket));
        return totalBuckets - extraBuckets;
    }
    public static int getBucketCount(double width , double height , double areaPerBucket){
        if(width <= 0 || height <=0 || areaPerBucket <= 0){
            return -1;
        }
        double wallArea = width * height;
        return (int) (Math.ceil(wallArea / areaPerBucket));
    }
    public static int getBucketCount(double area , double areaPerBucket){
        if(area <= 0 || areaPerBucket <= 0){
            return -1;
        }
        return (int) (Math.ceil(area / areaPerBucket));
    }
}
