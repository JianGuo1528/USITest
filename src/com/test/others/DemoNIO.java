package com.test.others;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class DemoNIO {
    @Test
    public void test01() throws IOException {
        File file = new File("./src/alg.png");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("./src/alg2.png");
        FileChannel fosChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fisChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fosChannel.close();
        fisChannel.close();
        fos.close();
        fis.close();
    }

    @Test
    public void test02() {
        System.out.println(maximumGap(new int[]{3,1,5,9}));
    }

    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int len = nums.length;
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        //Math.ceil与最小的比这个数大的整数，使bucket可以包含所有数
        int gap = (int)Math.ceil((double)(max - min) / (len - 1));

        int[] BucketsMIN = new int[len - 1];
        int[] BucketsMAX = new int[len - 1];
        Arrays.fill(BucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(BucketsMAX, Integer.MIN_VALUE);
        for (int num : nums) {
            //不考虑边界，所以把边界的min和max都拿出来，单独再考虑
            if (num == min || num == max) continue;

            int bucket = (num - min) / gap;
            BucketsMIN[bucket] = Math.min(BucketsMIN[bucket], num);
            BucketsMAX[bucket] = Math.max(BucketsMAX[bucket], num);
        }

        int result = 0;
        int previous = min;
        for (int i = 0; i < len - 1; i++) {
            if (BucketsMIN[i] == Integer.MAX_VALUE && BucketsMAX[i] == Integer.MIN_VALUE) {
                continue;
            }
            result = Math.max(result, BucketsMIN[i] - previous);
            previous = BucketsMAX[i];
        }
        result = Math.max(result, max - previous);
        return result;
    }
}
