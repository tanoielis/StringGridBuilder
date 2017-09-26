import org.junit.Test;

/**
 * Tests for the string grid builder
 */
public class StringGridBuilderTests {
    
    @Test
    public void testCreation() {
        int rows = 3;
        int cols = 3;
        
        char[][] item = {
                {'.','.','.'},
                {'.','-','.'},
                {'.','.','.'}};
        
        char[][] expandedGrid = {
                {'.','.','.','.','.','.','.','.','.'},
                {'.','-','.','.','-','.','.','-','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','-','.','.','-','.','.','-','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','-','.','.','-','.','.','-','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        
        
        String sgbString = ".........\n.-..-..-.\n.........\n.........\n.-..-..-.\n.........\n.........\n.-..-..-.\n.........\n";
        
        StringGridBuilder sgb = new StringGridBuilder(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sgb.addItem(item, j, i);
                assert sgb.hasGridChanged();
            }
        }
        
        sgb.expandGrid();
        
        assert !sgb.hasGridChanged();
        assert sgb.toString().equals(sgbString);
        
        char[][] sgbExpandedGrid = sgb.getExpandedGrid();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assert sgbExpandedGrid[i][j] == expandedGrid[i][j];
            }
        }
        
        // Test it works for 2 by 3?
        
        rows = 2;
        cols = 3;
        
        char[][] expandedGrid2 = {
                {'.','.','.','.','.','.','.','.','.'},
                {'.','-','.','.','-','.','.','-','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','-','.','.','-','.','.','-','.'},
                {'.','.','.','.','.','.','.','.','.'}};
        
        String sgbString2 = ".........\n.-..-..-.\n.........\n.........\n.-..-..-.\n.........\n";
        
        sgb = new StringGridBuilder(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sgb.addItem(item, j, i);
                assert sgb.hasGridChanged();
            }
        }
        
        sgb.expandGrid();
        
        assert !sgb.hasGridChanged();
        assert sgb.toString().equals(sgbString2);
    
        char[][] sgbExpandedGrid2 = sgb.getExpandedGrid();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assert sgbExpandedGrid2[i][j] == expandedGrid2[i][j];
            }
        }
    }
    
}
