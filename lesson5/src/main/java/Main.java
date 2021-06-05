
public class Main {
    public static void main(String[] args) {
        final StudentDAO studentDAO = new StudentDAO();

        for (int i = 0; i < 1000; i++) {
            final Student student = new Student("Name" + i, (int) (Math.random() * 5) + 1);
            studentDAO.save(student);
        }

        System.out.println(studentDAO.getAll());

        final Student updatedStudent1 = studentDAO.getById(2511);
        updatedStudent1.setName("Artem");
        studentDAO.update(updatedStudent1);
        System.out.println(studentDAO.getAll());


        studentDAO.delete(updatedStudent1);
        System.out.println(studentDAO.getAll());

        System.out.println(studentDAO.getById(2512));

    }


}
