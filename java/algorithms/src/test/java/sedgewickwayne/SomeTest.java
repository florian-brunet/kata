package sedgewickwayne;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.HashMap;

public class SomeTest {

    class Key {
        int key;

        Key(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key1 = (Key) o;

            if (key != key1.key) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    @Test
    public void testHashMapResize() throws Exception {
        HashMap<Key, Integer> map = Maps.newHashMap();
        for (int k = 0; k < 16; k++) {
            map.put(new Key(k), k);
        }
        map.put(new Key(1), 1);
        System.out.println(map);
    }
}
