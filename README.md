# StringGridBuilder
A library for managing 2d character arrays
-------------------------------------------

A StringGridBuilder can be used to easily combine multiple 2d char arrays to create a larger 2d array.

# Example usage:

```java
public StringGrid() {
    StringGridBuilder sgb = new StringGridBuilder(2, 2);
   
    char[][] a = {
            {'a','a','a'},
            {'a','a','a'},
            {'a','a','a'}
    };
    char[][] b = {
            {'b','b','b'},
            {'b','b','b'},
            {'b','b','b'}
    };
    char[][] c = {
            {'c','c','c'},
            {'c','c','c'},
            {'c','c','c'}
    };
    
    sgb.addItem(a, 0, 0);
    sgb.addItem(a, 0, 1);
    sgb.addItem(b, 1, 0);
    sgb.addItem(c, 1, 1);
      
    sgb.expandGrid();
    
    System.out.println(sgb.toString());
}
```
# OUTPUT
```
aaabbb
aaabbb
aaabbb
aaaccc
aaaccc
aaaccc
```
