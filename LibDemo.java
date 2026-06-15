public class LibDemo {
    public static void main(String[] args) {

        Library lib = new Library();
        // books - isbn auto generated
        Book bk1 = new Book("Atomic Habits", "James Clear");
        Book bk2 = new Book("The 5AM Club", "Robin Sharma");
        Book bk3 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");

        System.out.println("Books Added");
        System.out.println(lib.addBook(bk1));
        System.out.println(lib.addBook(bk2));
        System.out.println(lib.addBook(bk3));
        System.out.println(" ");


        // members - id auto generated
        Member David = new Member("David");
        Member Andrew = new Member("Andrew");
        System.out.println("Members Added");
        System.out.println(lib.registerMember(David));
        System.out.println(lib.registerMember(Andrew));

        System.out.println(lib.getState());

        // lending - using actual id from member object
        System.out.println(lib.lendBook(bk1.getIsbn(), David.getMemberId()));
        System.out.println(lib.lendBook(bk1.getIsbn(), Andrew.getMemberId()));
        System.out.println(lib.lendBook(bk3.getIsbn(), Andrew.getMemberId()));
        System.out.println(lib.getState());

        // returning
        System.out.println(lib.returnBook(bk1.getIsbn(), David.getMemberId()));

        System.out.println(lib.getState());
        // search
        System.out.println(lib.searchByTitle("The 5AM Club"));
    }
}