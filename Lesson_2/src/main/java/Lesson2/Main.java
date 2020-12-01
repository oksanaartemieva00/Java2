package Lesson2;

public class Main {
    private static final int needSize=4;
    private static final String[][] rightArray=new String[][]{
            {"1","1","1","1",},
            {"2","3","4","5",},
            {"6","6","6","6"},
            {"7","8","9","10"},
    };
    private static final String[][] wrongArray=new String[][]{
            {"1","1","1","1"},
            {"2","3","4"},
            {"5","5","5","5"},
            {"6","7","8","9","10"},
    };
    private static final String[][] wrongValueArray=new String[][]{
            {"1","2","3","4"},
            {"5","5","5","5"},
            {"6","7","8","9"},
            {"10","10","10","10"},
    };

    public static void main(String[] args) {
        try{
            int result=sumArray(rightArray);
            //либо (wrongArray), либо (wrongValueArray)
            System.out.println("Sum "+result);
        }catch(MyArraySizeException e){
            System.err.println("Mistake");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }catch(MyArrayDataException e){
            System.err.println("Data mistake");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    private static int sumArray(String[][] data)throws MyArraySizeException,MyArrayDataException{
        checkArraySize(data);
        int resultArray=0;
        for (int rowNumber = 0; rowNumber <data.length ; rowNumber++) {
            String [] row=data[rowNumber];
            for (int columnNumber = 0; columnNumber <row.length ; columnNumber++) {
                String value=row[columnNumber];
                try{
                    resultArray+=Integer.parseInt(value);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException(value,rowNumber,columnNumber);
                }

            }

        }
        return resultArray;
    }
    private static void checkArraySize(String [][] data){
        if(data.length!=needSize){
            throw new MyArraySizeException();
        }
        for(String[]row:data){
            if(row.length!=needSize){
                throw new MyArraySizeException();
            }
        }
    }

}
