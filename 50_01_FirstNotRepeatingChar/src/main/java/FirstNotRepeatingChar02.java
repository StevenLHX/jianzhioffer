/**
 * 时间复杂度为O(n)的解法
 * 哈希表求解
 */
public class FirstNotRepeatingChar02 {
    public static void findFirst(String str){
        if (str==null){
            return;
        }
        int i=0;
        char[] arr=str.toCharArray();
        int[] hashTable=new int[256];
        for (i=0;i<256;i++){
            hashTable[i]=0;
        }
        char[] hashKey=arr;
        for (i=0;i<hashKey.length;i++){
            int tmp=hashKey[i];//将char转为int，即转为其对应的ascall码
            hashTable[tmp]++;
        }
        for (i=0;i<hashKey.length;i++){
            if (hashTable[hashKey[i]]==1){
                System.out.println(hashKey[i]);
                return;// 找出只出现一次的字符后就退出，若要都找出的话不退出就行
            }
        }
    }

    public static void main(String[] args) {
        String str = "abaccdeff";
        findFirst(str);
    }
}
