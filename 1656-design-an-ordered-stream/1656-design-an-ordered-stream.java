import java.util.ArrayList;
import java.util.List;
class OrderedStream {
    String  [] arr ;
    int ptr;

    public OrderedStream(int n) {
        arr = new String[n];
        ptr=0;

    }

    public List<String> insert(int idKey, String value) {
          arr[idKey - 1] = value;

        List<String> result = new ArrayList<>();
        while(ptr<arr.length && arr[ptr]!= null){
             result.add(arr[ptr]);
            ptr++;

        }
        return result;
        
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */