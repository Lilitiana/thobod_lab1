import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.reduce.IntSumReducer;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    MapDriver<Object, Text, Text, Item> mapDriver;
    ReduceDriver<Text, Item, Text, Item> reduceDriver;
    MapReduceDriver<Object, Text, Text, Item, Text, Item> mapReduceDriver;
    @Before
    public void setUp() {
        Main.TokenizerMapper mapper = new Main.TokenizerMapper();
        IntSumReducer reducer = new IntSumReducer();
        mapDriver = MapDriver.newMapDriver(mapper);
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
        mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
    }
    @Test
    public void testMapper() {
        mapDriver.withInput(new Object(), new Text("ip1 - - [24/Apr/2011:04:06:01 -0400] \"GET /~strabal/grease/photo9/927-3.jpg HTTP/1.1\" 200 40028 \"-\" \"Mozilla/5.0 (compatible; YandexImages/3.0; +http://yandex.com/bots)\""));
        Item item = new Item();
        item.setSum(40028);
        item.setCount(1);
        mapDriver.withOutput(new Text("ip1"), item);
        mapDriver.runTest();
    }

}