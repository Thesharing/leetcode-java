# Online Judge Code

## Intro

These are source codes of exercises which I completed on three online judge websites, mostly using Java.

[Bailian（百练）](http://bailian.openjudge.cn/)

[UVa Online Judge](https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=827)

[LeetCode (Algorithm)](code.com/problemset/algorithms/)

## Note

1. **C**	double要注意不能用 = 判断相等，最好用 a - b < 0.000001来判断
2. **C**	`printf("%.lf", a);`是会四舍五入的！也就是说，`printf("%.lf", 0.95);`输出的是1 --**Java**中的System.out.format也是一样的。
3. **Java** 利用`System.out.format()`来输出带格式的字符串，和C的`printf`比较像，不过可以通过$1来指定对应项。

![format格式](http://7xr64j.com1.z0.glb.clouddn.com/code/snip_20160819114131.png)

4. **Java**	常用import：`import java.util.*;` `import java.lang.*;`
5. **Java**	[Scanner](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)要大写，来自`import java.util.Scanner;`。常用：`sc.next()` `sc.nextInt()` `sc.nextLine()` `sc.hasNext()` `sc.hasNextInt()` `sc.hasNextLine()`。
6. **Java**	[String](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)也要大写，来自`import java.lang.String`。常用：`s.charAt()`，`s.toCharArray()`。
7. **C**  [strchr](http://www.cplusplus.com/reference/cstring/strchr/) `char * strchr ( const char * str, int character );` 相当于Java中的indexOf，只不过返回的是一个char*类型。通过减去首地址指针+1可以得到index。
8. **C**  [sprintf](http://www.cplusplus.com/reference/cstdio/sprintf/) 将字符串写入字符串，`sprintf(char*, const char* format, args...);
9. **C**  [fgets](http://www.cplusplus.com/reference/cstdio/fgets/) `char * fgets ( char * str, int num, FILE * stream );` 从流中读取一整行；还有一个[gets](http://www.cplusplus.com/reference/cstdio/gets/) `char * gets ( char * str )` 直接读取一行（包括空格，会保留读到的换行符）；`getchar()`会读取所有字符（）；`scanf("%s", str);`会在空格、Tab和回车处停下，并不读入他们。
10. **Java** `int[][] = new int [x][y];` 自动初始化为0。boolean会填充为*false*。
11. **Java** `Random ran = new Random(long seed);` `ran.nextInt(int limit);` `ran.nextDouble()`返回的是0.0-1.0的double。
12. **Java** `+`（一元加号）会将较小类型的操作数提升为int（比如byte，short）。
13. **Java** `float f = 1e-43f;`（因为编译器会自动识别1e43为double，所以要显式标为float）。
14. **Java** float或double转int时总是截尾，通过`Math.round()`即可四舍五入。
15. **Java** 容器分为Collection和Map，而Collection分为List和Set。
[List](https://docs.oracle.com/javase/7/docs/api/java/util/List.html)分为[ArrayList](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)和[LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)。
ArrayList在随机访问时比较快（`get()`），但是在队列中间插入和删除比较慢；LinkedList则相反。
ArrayList常用操作：`add`, `clear`, `get`, `remove`, `set`。
LinkedList通过实现List<E>和Deque<E>（Deque<E>实现了Queue<E>）来实现队列、双向队列甚至栈等容器。LinkedList可以进行的操作非常多，例如`add`, `get`, `offer`, `peek`, `poll`还有`remove`。 以上这些操作都有`-First`和`-Last`版本分别对应队列第一个和队列最后一个。LinkedList还提供了`push`和`pop`用于模拟堆栈。
Vector衍生出[Stack](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)，Stack的操作大体为`peek`, `push`和`pop`。
要注意List的迭代器有[Iterator](https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html)和[ListIterator](https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html)，ListIterator可以进行previous操作，而Iterator不行。
Set和List比较像，只不过Set中不能存放相同的元素。HashSet采用Hash存放，而TreeSet则是具有排序的存放。
[Map](https://docs.oracle.com/javase/7/docs/api/java/util/Map.html)存放的是键值对，他也被称为关联数组。Map的遍历可以通过`map.entrySet()`、`map.keySet()`（返回的是Set）以及`map.values()`（返回的是Collection）进行遍历。
对于Queue，不仅有LinkedList，还有一个优先级队列[PriorityQueue](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html)，通过`PriorityQueue(int initialCapacity, Comparator<? super E> comparator)`指定comparator从而指定优先级。

![STL说明](http://7xr64j.com1.z0.glb.clouddn.com/16-8-25/STL.jpg)

16. **Java** 通过String的`split`、`replaceFirst`和`replaceAll`用到正则表达式。当然也可以通过声明[Pattern](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#sum)来使用。`Pattern pattern = Pattern.compile(String regex);`然后[Matcher](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html) `Matcher m = pattern.matcher(String targetStr);`。`matcher.find()`将返回是否找到。我们也可以直接用`static boolean Pattern.matches(String regex, CharSequence input)`来匹配。
17. **Java** 通过`Arrays.asList`和`list.toArray`可以在Arrays和List之间互相变换。StringBuilder.append() == String的+=。
18. **Java** 通过`Arrays.sort(int[])`和`Collections.sort(List<T>)`都可以进行排序。Arrays里还有fill和copyOf以及binarySearch。Collections里有reverse()。StringBuilder有reverse函数供调用。
19. **Java** 对于多维数组来说，有`static boolean deepEquals(Object[] a1, Object[] a2)`、`deepToString()`。
20. **Java** 对于数组的复制，[Arrays](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html)有`static int[] Arrays.copyOf(int[] ori, int newLength)`, which will automatically truncate or pad the new array with *zero*. 
另一种是`static int[]	copyOfRange(int[] original, int from, int to)`，包含from但不包含to。这里的from和to都是原数组的。
还有`static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`，这是一种比较快的方式。（[参考](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#arraycopy(java.lang.Object,%20int,%20java.lang.Object,%20int,%20int))）
21. **Java** `Arrays.binarySearch()`只能在已经排好序的数组里使用。`Arrays.sort()`有两个重载，一个是：`Arrays.sort(Object[] a, int fromIndex, int toIndex)`，另一个是`Arrays.sort(T[] a, Comparator<? super T> c)`。后者可以拓展为`Arrays.sort(s, Collections.reverseOrder())`，而对于字符串来说，sort()会按照字典序也就是先全部大写字母再小写字母的顺序排序，因此可以通过`Arrays.sort(str, String.CASE_INTENSITIVE_ORDER)`来忽略大小写进行排序。
22. **C** `cout << setw(5) << str;`可以设置输出字符宽度。
23. **树**是**递归**的。