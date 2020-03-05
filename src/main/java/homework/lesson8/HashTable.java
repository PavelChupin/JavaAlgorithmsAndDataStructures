package homework.lesson8;

public class HashTable<T extends Item> {
    private T[] hashArr;
    private int arrSize;
    private T nonItem;

    public HashTable(int size){
        this.arrSize = size;
        hashArr = (T[]) new Item [arrSize];
        nonItem = (T) new Item (-1);
    }

    public void display(){
        for(int i=0;i<arrSize;i++){
            if(hashArr[i] !=null){
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public int hashFuncDouble(int key){
        return 5 - key % 5;
    }

    public void insert(T item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            hashVal+=stepSize;
            hashVal%=arrSize;
        }
        hashArr[hashVal] = item;
    }

    public T delete(int key){
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key){
                T temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            hashVal+=stepSize;
            hashVal%=arrSize;
        }
        return null;

    }

    public T find(int key){
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key){
                return hashArr[hashVal];
            }
            hashVal+=stepSize;
            hashVal%=arrSize;
        }
        return null;

    }
}
