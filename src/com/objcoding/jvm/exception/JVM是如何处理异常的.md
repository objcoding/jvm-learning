# JVM 是如何处理异常的？


```bash
$ javac Foo.java
$ javap -p -v Foo

```


```
Classfile /Users/zhangchenghui/Documents/jvm-learning/src/com/objcoding/jvm/exception/Foo.class
  Last modified 2018-9-8; size 653 bytes
  MD5 checksum ef4af322a9c9b8a2bc1cb1726671d4a1
  Compiled from "Foo.java"
public class com.objcoding.jvm.exception.Foo
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #8.#24         // java/lang/Object."<init>":()V
   #2 = Fieldref           #7.#25         // com/objcoding/jvm/exception/Foo.tryBlock:I
   #3 = Fieldref           #7.#26         // com/objcoding/jvm/exception/Foo.finallyBlock:I
   #4 = Class              #27            // java/lang/Exception
   #5 = Fieldref           #7.#28         // com/objcoding/jvm/exception/Foo.catchBlock:I
   #6 = Fieldref           #7.#29         // com/objcoding/jvm/exception/Foo.methodExit:I
   #7 = Class              #30            // com/objcoding/jvm/exception/Foo
   #8 = Class              #31            // java/lang/Object
   #9 = Utf8               tryBlock
  #10 = Utf8               I
  #11 = Utf8               catchBlock
  #12 = Utf8               finallyBlock
  #13 = Utf8               methodExit
  #14 = Utf8               <init>
  #15 = Utf8               ()V
  #16 = Utf8               Code
  #17 = Utf8               LineNumberTable
  #18 = Utf8               test
  #19 = Utf8               StackMapTable
  #20 = Class              #27            // java/lang/Exception
  #21 = Class              #32            // java/lang/Throwable
  #22 = Utf8               SourceFile
  #23 = Utf8               Foo.java
  #24 = NameAndType        #14:#15        // "<init>":()V
  #25 = NameAndType        #9:#10         // tryBlock:I
  #26 = NameAndType        #12:#10        // finallyBlock:I
  #27 = Utf8               java/lang/Exception
  #28 = NameAndType        #11:#10        // catchBlock:I
  #29 = NameAndType        #13:#10        // methodExit:I
  #30 = Utf8               com/objcoding/jvm/exception/Foo
  #31 = Utf8               java/lang/Object
  #32 = Utf8               java/lang/Throwable
{
  private int tryBlock;
    descriptor: I
    flags: ACC_PRIVATE

  private int catchBlock;
    descriptor: I
    flags: ACC_PRIVATE

  private int finallyBlock;
    descriptor: I
    flags: ACC_PRIVATE

  private int methodExit;
    descriptor: I
    flags: ACC_PRIVATE

  public com.objcoding.jvm.exception.Foo();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 7: 0

  public void test();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=4, args_size=1
         0: iconst_0
         1: istore_1
         2: iload_1
         3: bipush        100
         5: if_icmpge     75
         8: aload_0
         9: iconst_0
        10: putfield      #2                  // Field tryBlock:I
        13: iload_1
        14: bipush        50
        16: if_icmpge     27
        19: aload_0
        20: iconst_2
        21: putfield      #3                  // Field finallyBlock:I
        24: goto          69
        27: iload_1
        28: bipush        80
        30: if_icmpge     41
        33: aload_0
        34: iconst_2
        35: putfield      #3                  // Field finallyBlock:I
        38: goto          75
        41: aload_0
        42: iconst_2
        43: putfield      #3                  // Field finallyBlock:I
        46: return
        47: astore_2
        48: aload_0
        49: iconst_1
        50: putfield      #5                  // Field catchBlock:I
        53: aload_0
        54: iconst_2
        55: putfield      #3                  // Field finallyBlock:I
        58: goto          69
        61: astore_3
        62: aload_0
        63: iconst_2
        64: putfield      #3                  // Field finallyBlock:I
        67: aload_3
        68: athrow
        69: iinc          1, 1
        72: goto          2
        75: aload_0
        76: iconst_3
        77: putfield      #6                  // Field methodExit:I
        80: return
      Exception table:
         from    to  target type
             8    19    47   Class java/lang/Exception
            27    33    47   Class java/lang/Exception
             8    19    61   any
            27    33    61   any
            47    53    61   any
      LineNumberTable:
        line 14: 0
        line 16: 8
        line 17: 13
        line 25: 19
        line 19: 27
        line 25: 33
        line 21: 46
        line 22: 47
        line 23: 48
        line 25: 53
        line 26: 58
        line 25: 61
        line 14: 69
        line 28: 75
        line 29: 80
      StackMapTable: number_of_entries = 7
        frame_type = 252 /* append */
          offset_delta = 2
          locals = [ int ]
        frame_type = 24 /* same */
        frame_type = 13 /* same */
        frame_type = 69 /* same_locals_1_stack_item */
          stack = [ class java/lang/Exception ]
        frame_type = 77 /* same_locals_1_stack_item */
          stack = [ class java/lang/Throwable ]
        frame_type = 7 /* same */
        frame_type = 250 /* chop */
          offset_delta = 5
}

```