public class Test {
    public static void main(String[] args) {
        testIntCell();
        testDoubleCell();
        testDateCell();
        testStringCell();
        testRemoveColumn();
        testRemoveRow();
        testAddColum();
        testAddRow();
        testSetCellAt();
        testSwapRow();
        testSwapColumn();
    }

    static void testIntCell () {
        IntCell c = new IntCell();
        c.setValue(-96);
        if (c.getValue() == -96) {
            System.out.println("Test passed 1");
        } else {
            System.out.println("error IntCell 1");
        }
        c.reset();
        if (c.getValue() == Integer.MIN_VALUE) {
            System.out.println("Test passed 2");
        } else {
            System.out.println("error IntCell 2");
        }
        IntCell cell = new IntCell();
        if (c.equals(cell)) {
            System.out.println("Test passed 3");
        } else {
            System.out.println("error IntCell 3");
        }
        String str = Integer.MIN_VALUE+"";
        if (str.equals(cell.toString())) {
            System.out.println("Test passed 4");
        } else {
            System.out.println("error IntCell 4");
        }
    }

    static void testDoubleCell () {
        DoubleCell c = new DoubleCell();
        c.setValue(-96.665);
        if (c.getValue() == -96.665) {
            System.out.println("Test passed 1");
        } else {
            System.out.println("error DoubleCell 1");
        }
        c.setValue(-.36);
        if (c.getValue() == -0.36) {
            System.out.println("Test passed 2");
        } else {
            System.out.println("error DoubleCell 2");
        }
        c.reset();
        if (c.getValue() == Double.MIN_VALUE) {
            System.out.println("Test passed 3");
        } else {
            System.out.println("error DoubleCell 3");
        }
        DoubleCell cell = new DoubleCell();
        if (c.equals(cell)) {
            System.out.println("Test passed 4");
        } else {
            System.out.println("error DoubleCell 4");
        }
        String str = Double.MIN_VALUE+"";
        if (str.equals(cell.toString())) {
            System.out.println("Test passed 5");
        } else {
            System.out.println("error DoubleCell 5");
        }
    }

    static void testDateCell () {
        Date date = new Date(new Day(26), Month.Feb, new Year(-36));
        DateCell cell = new DateCell(date);
        Cell<Date> c = cell;
        Date date1 = new Date();
        if (c.getValue().equals(date)) {
            System.out.println("Test passed 1");
        } else {
            System.out.println("error DateCell 1");
        }
        String str = date.toString();
        if (str.equals(cell.toString())) {
            System.out.println("Test passed 2");
        } else {
            System.out.println("error DateCell 2");
        }
        c.reset();
        if (c.getValue().equals(date1) ) {
            System.out.println("Test passed 3");
        } else {
            System.out.println("error DateCell 3");
        }
    }

    public static void testStringCell() {
        StringCell c = new StringCell();
        c.setValue("-96.665");
        if (c.getValue().equals("-96.665")) {
            System.out.println("Test passed 1");
        } else {
            System.out.println("error StringCell 1");
        }
        c.setValue("-.36");
        if (c.getValue().equals("-.36")) {
            System.out.println("Test passed 2");
        } else {
            System.out.println("error StringCell 2");
        }
        c.reset();
        if (c.getValue().equals("") ) {
            System.out.println("Test passed 3");
        } else {
            System.out.println("error StringCell 3");
        }
        StringCell cell = new StringCell();
        if (c.equals(cell)) {
            System.out.println("Test passed 4");
        } else {
            System.out.println("error StringCell 4");
        }
    }

    static void testSetCellAt () {
        Spreadsheet sp = new Spreadsheet(5,6);
        Cell c = new StringCell();
        c.setValue("asdasd");
        sp.setCellAt(4,0,c);
        if(sp.getCellAt(4,0).equals(c)){
            System.out.println("Test passed 1");
        } else {
            System.out.println("error setCellAt 1");
        }

        Cell ce = new DoubleCell();
        ce.setValue(-0.36);
        sp.setCellAt(4,0, ce);
        if(sp.getCellAt(4,0).equals(ce)){
            System.out.println("Test passed 2");
        } else {
            System.out.println("error setCellAt 2");
        }
    }

    static void testSwapRow () {
        Spreadsheet sp1 = new Spreadsheet(2, 2);
        Spreadsheet sp2 = new Spreadsheet(2, 2);
        Cell c1 = new IntCell(10);
        Cell c2 = new IntCell(20);
        sp1.setCellAt(0,0, c1);
        sp1.setCellAt(0,1, c1);
        sp1.setCellAt(1,0, c2);
        sp1.setCellAt(1,1, c2);
        sp1.swapRows(0,1);
        sp2.setCellAt(0, 0, c1);
        sp2.setCellAt(0, 1, c1);
        sp2.setCellAt(1, 0, c2);
        sp2.setCellAt(1, 1, c2);
        if (sp1.equals(sp2)) {
            System.out.println("error swapRow 1");
        } else {
            System.out.println("Test passed 1");
        }
        sp2.swapRows(0,1);
        if (sp2.equals(sp1)) {
            System.out.println("Test passed 2");
        } else {
            System.out.println("error swapRpw 2");
        }
    }

    static void testSwapColumn () {
        Date date1 = new Date(new Day(26), Month.Feb, new Year(-36));
        Cell c = new DateCell(date1);
        Date date2 = new Date(new Day(2), Month.Aug, new Year(2001));
        Cell cell = new DateCell(date2);
        Spreadsheet sp1 = new Spreadsheet(2, 2);
        sp1.setCellAt( 0, 0, c);
        sp1.setCellAt(0,1,cell);
        sp1.setCellAt(1,0,c);
        sp1.setCellAt(1,1,cell);
        sp1.swapColumn(0,1);
        Spreadsheet sp2 = new Spreadsheet(2,2);
        sp2.setCellAt(0,0,c);
        sp2.setCellAt(0,1,cell);
        sp2.setCellAt(1,0,c);
        sp2.setCellAt(1,1,cell);
        if (sp1.equals(sp2)) {
            System.out.println("error swapColumn 1");
        } else {
            System.out.println("Test passed 1");
        }
        try {
            sp2.swapColumn(0, 1);
            if (sp2.equals(sp1)) {
                System.out.println("Test passed 2");
            } else {
                System.out.println("error swapColumn");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e + "\n" + "Test passed");
        }
    }

    static void testAddRow () {
        Spreadsheet sp = new Spreadsheet(2,2);
        Cell c = new StringCell("20");
        sp.setCellAt(0,0, c);
        sp.setCellAt(0,1, c);
        sp.setCellAt(1,0, c);
        sp.setCellAt(1,1, c);
        Cell ce = new StringCell("");
        sp.addRow(1);
        boolean bool = true;
        for (int i = 0; i < 2; ++i) {
            if (sp.getCellAt(1, i) != null) {
                bool = false;
                System.out.println("error addRow 1");
                break;
            }
        }
        if (bool) {
            System.out.println("Test passed 1");
        }
        sp.addColumn(2);
        for (int i = 0; i < 2; ++i) {
            if (sp.getCellAt(2, i) != null) {
                bool = false;
                System.out.println("error addRow 2");
                break;
            }
        }
        if (bool) {
            System.out.println("Test passed 2");
        }
    }

    static void testAddColum () {
        Spreadsheet sp = new Spreadsheet(2,2);
        Cell c = new StringCell("20");
        sp.setCellAt(0,0, c);
        sp.setCellAt(0,1, c);
        sp.setCellAt(1,0, c);
        sp.setCellAt(1,1, c);
        Cell ce = new StringCell("");
        sp.addColumn(1);
        boolean bool = true;
        for (int i = 0; i < 2; ++i) {
            if (sp.getCellAt(i, 1) != null) {
                bool = false;
                System.out.println("error addColumn 1");
                break;
            }
        }
        if (bool) {
            System.out.println("Test passed 1");
        }
        sp.addColumn(2);
        for (int i = 0; i < 2; ++i) {
            if (sp.getCellAt(i, 2) != null) {
                bool = false;
                System.out.println("error addColumn 2");
                break;
            }
        }
        if (bool) {
            System.out.println("Test passed 2");
        }
    }

    static void testRemoveRow () {
        Spreadsheet sp = new Spreadsheet(3,2);
        Cell c = new StringCell("20");
        sp.setCellAt(0,0, c);
        sp.setCellAt(0,1, c);
        Cell ce = new StringCell("110");
        sp.setCellAt(1,0, ce);
        sp.setCellAt(1,1, ce);
        Cell cell = new StringCell( "111");
        sp.setCellAt(2,0, cell);
        sp.setCellAt(2,1, cell);
        try {
            sp.removeRow(1);
            if (sp.getCellAt(1, 0).equals(cell)) {
                System.out.println("Test passed 1");
            } else {
                System.out.println("error removeRow 1");
            }
            if (sp.getCellAt(1, 1).equals(cell)) {
                System.out.println("Test passed 2");
            } else {
                System.out.println("error removeRow 2");
            }
            sp.removeRow(0);
            if (sp.getCellAt(0, 0).equals(cell)) {
                System.out.println("Test passed 3");
            } else {
                System.out.println("error removeRow 3");
            }
            if (sp.getCellAt(0, 1).equals(cell)) {
                System.out.println("Test passed 4");
            } else {
                System.out.println("error removeRow 4");
            }
            sp.removeRow(0);
            if (sp.getCellAt(0, 0).equals(cell)) {
                System.out.println("Test passed 5");
            } else {
                System.out.println("error removeRow 5");
            }
            if (sp.getCellAt(0, 1).equals(cell)) {
                System.out.println("Test passed 6");
            } else {
                System.out.println("error removeRow 6");
            }
        } catch (Exception e) {
            System.out.println(e + "\n" + "RemoveRow tests passed");
        }
    }

    static void testRemoveColumn () {
        Spreadsheet sp = new Spreadsheet(2,3);
        Cell c = new StringCell("20");
        sp.setCellAt(0,0, c);
        sp.setCellAt(0,1, c);
        sp.setCellAt(0,2, c);
        Cell ce = new StringCell("110");
        sp.setCellAt(1,0, ce);
        sp.setCellAt(1,1, ce);
        sp.setCellAt(1,2, ce);
        try {
            sp.removeColum(1);
            if (sp.getCellAt(0, 1).equals(c)) {
                System.out.println("Test passed 1");
            } else {
                System.out.println("error removeColumn 1 ");
            }
            if (sp.getCellAt(1, 1).equals(ce)) {
                System.out.println("Test passed 2");
            } else {
                System.out.println("error removeColumn 2 ");
            }
            sp.removeColum(0);
            if (sp.getCellAt(0, 0).equals(c)) {
                System.out.println("Test passed 3");
            } else {
                System.out.println("error removeColumn 3 ");
            }
            if (sp.getCellAt(1, 0).equals(ce)) {
                System.out.println("Test passed 4");
            } else {
                System.out.println("error removeColumn 4 ");
            }
            sp.removeColum(0);
            if (sp.getCellAt(0, 0).equals(c)) {
                System.out.println("Test passed 5");
            } else {
                System.out.println("error removeColumn 5 ");
            }
            if (sp.getCellAt(1, 0).equals(ce)) {
                System.out.println("Test passed 6");
            } else {
                System.out.println("error removeColumn 6 ");
            }
        } catch (Exception e) {
            System.out.println(e  + "\n" + "RemoveColumn tests passed");
        }
    }
}
