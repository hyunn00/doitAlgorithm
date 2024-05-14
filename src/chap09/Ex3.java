package chap09;

import java.util.Scanner;

public class Ex3 {
    static Scanner scanner = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;
        private Integer no;
        private String name;

        Integer keyCode() {
            return no;
        }

        public String toString() {
            return name;
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = scanner.nextInt();
            }

            if((sw & NAME) == NAME) {
                System.out.print("이름 : ");
                name = scanner.next();
            }
        }
    }

    enum Menu {
        ADD("삽입"),
        REMOVE("삭제"),
        SEARCH("검색"),
        PRINT("출력"),
        PRINTR("내림차순 출력"),
        MIN_KEY("가장 작은 키값"),
        MIN_DATA("가장 작은 키(key)를 갖는 데이터"),
        MAX_KEY("가장 큰 키값"),
        MAX_DATA("가장 큰 키(key)를 갖는 데이터"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx) {
            for(Menu m : Menu.values())
                if(m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    static Menu SelectMenu() {
        int key;
        do {
            for(Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
            }
            System.out.print(" : ");
            key = scanner.nextInt();
        } while(key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data ptr;
        Data temp = new Data();

        BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

        do {
            switch (menu = SelectMenu()) {
                case ADD :
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.keyCode(), data);
                    break;
                case REMOVE :
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.keyCode());
                    break;
                case SEARCH:
                    temp.scanData("검색", Data.NO);
                    ptr = tree.search(temp.keyCode());
                    if(ptr == null)
                        System.out.println("해당 데이터가 없습니다.");
                    else
                        System.out.println("그 번호의 이름은 "+ptr+"입니다.");
                    break;
                case PRINT:
                    tree.print();
                    break;
                case PRINTR:
                    tree.printReverse();
                    break;
                case MIN_KEY:
                    Integer minkey = tree.getMinKey();
                    if(minkey != null)
                        System.out.println("가장 작은 키값은 "+minkey+"입니다.");
                    else
                        System.out.println("데이터가 없습니다.");
                    break;
                case MIN_DATA:
                    ptr = tree.getDataWithMinKey();
                    if(ptr != null)
                        System.out.println("가장 작은 키값을 갖는 데이터는 "+ptr+"입니다.");
                    else
                        System.out.println("데이터가 없습니다.");
                    break;
                case MAX_KEY:
                    Integer maxkey = tree.getMaxKey();
                    if(maxkey != null)
                        System.out.println("가장 큰 키값은 "+maxkey+"입니다.");
                    else
                        System.out.println("데이터가 없습니다.");
                    break;
                case MAX_DATA:
                    ptr = tree.getDataWithMaxKey();
                    if(ptr != null)
                        System.out.println("가장 큰 키값을 갖는 데이터는 "+ptr+"입니다.");
                    else
                        System.out.println("데이터가 없습니다.");
                    break;
            }
        } while(menu != Menu.TERMINATE);
    }
}
