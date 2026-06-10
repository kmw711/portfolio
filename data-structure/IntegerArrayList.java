public class IntegerArrayList implements IntegerListInterface{
    private Integer[] item;
    private int numItems; // 리스트의 길이
    private static final int DEFAULT_CAPACITY = 64;

    public IntegerArrayList() {  // 생성자 1
        item = new Integer[DEFAULT_CAPACITY];
        numItems = 0;
    }
    public IntegerArrayList(int n) {  // 생성자 2
        item = new Integer[n];
        numItems = 0;
    }

    @Override
    public void add(int i, Integer x) {
        if(numItems < i || i < 0){
            System.out.println(i+"번지는 잘못된 접근입니다. 값을 삽입할 수 없습니다.");
        }else{
            for(int y=numItems; y > i ; y--){
                item[y] = item[y-1];
            }
            item[i] = x;
            numItems++;
        }
    }

    @Override
    public void append(Integer x) {
        if(numItems >= item.length){
            System.out.println("더이상 아이템을 추가할 수 없습니다.");
        }else{
            item[numItems] = x;
            numItems++;
        }
    }

    @Override
    public Integer remove(int i) {
        if( numItems <= i || i < 0){
            System.out.println(i+"번지에는 값이 없습니다. 잘못된 접근입니다.");
            return null;
        }else{
            int y;
            Integer ret = item[i];
            for(y=i; y<numItems-1; y++){
                item[y] = item[y+1];
            }
            item[y] = null;
            numItems--;
            return ret;
        }
    }

    @Override
    public boolean removeItem(Integer x) {
        for(int i=0; i<numItems; i++){
            if(item[i] == x){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(int i) {
        if(numItems <= i || i < 0){
            return null;
        }
        return item[i];
    }

    @Override
    public void set(int i, Integer x) {
        if( numItems <= i || i < 0){
            System.out.println(i+"번지에는 값이 없습니다. 잘못된 접근입니다.");
        }else{
            item[i] = x;
        }
    }

    @Override
    public int indexOf(Integer x) {
        for(int i=0; i<numItems; i++){
            if(item[i] == x){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }
    @Override
    public void clear() {
        item = new Integer[DEFAULT_CAPACITY];
        numItems = 0;
    }
    static void main() {
        IntegerArrayList il = new IntegerArrayList();
        il.append(10);
        il.append(20);
        il.append(30);
        il.add(1,40);
        System.out.println(il.remove(0));
        if(il.removeItem(40)){
            System.out.println("40값 삭제 성공");
        }else{
            System.out.println("40값 삭제 실패");
        }
        System.out.println(il.indexOf(30));
    }
}