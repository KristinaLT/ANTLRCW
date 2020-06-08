import java.util.Stack;
import java.io.FileWriter;



public class LLVM  {
    static int reg = 1;

    private static String header_text = "";
    private static String main_text = "";
    private static String buffer = "";
    private static int str_i = 0;
    private static int main_reg = 1;
    private static int br = 0;
    static boolean stack_pop;

    static Stack<Integer> br_stack = new Stack<>();
    static Stack<Integer> br_loop= new Stack<>();

    static String generate() {
        main_text += buffer;
        formatMainText();
        String text = "";
        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @scanf(i8*, ...)\n";
        text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
        text += "@strps = constant [4 x i8] c\"%s\\0A\\00\"\n";
        text += "@strsi = constant [3 x i8] c\"%d\\00\"\n";
        text += "@strsd = constant [4 x i8] c\"%lf\\00\"\n";
        text += "\n";
        text += header_text;
        text += "define i32 @main() nounwind {\n";
        text += main_text;
        text += "  ret i32 0\n";
        text += "}\n";
        try(FileWriter file = new FileWriter("src/bc.ll", false)) {
            file.write(text);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    static void print(String text) {
        int str_len = text.length();

        String str_type = "[" + (str_len + 2) + " x i8]";
        header_text += "@str" + str_i + " = constant" + str_type + " c\"" + text + "\\0A\\00\"\n";
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( " + str_type + ", " + str_type + "* @str" + str_i + ", i32 0, i32 0))\n";
        str_i++;
        reg++;
    }

    static void printf_i32(String id, boolean global) {
        if (global) {
            buffer += "%" + reg + " = load i32, i32* @" + id + "\n";
        } else {
            buffer += "%" + reg + " = load i32, i32* %" + id + "\n";
        }
        reg++;
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %" + (reg - 1) + ")\n";
        reg++;
    }

    static void printf_double(String id, boolean gloabal) {
        if (gloabal) {
            buffer += "%" + reg + " = load double, double* @" + id + "\n";
        } else {
            buffer += "%" + reg + " = load double, double* %" + id + "\n";
        }
        reg++;
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %" + (reg - 1) + ")\n";
        reg++;
    }

    static void printf_string(String id, int length, boolean global, String function) {
        if (global) {
            buffer += "%" + reg + " = getelementptr inbounds [" + (length + 1) + " x i8], [" + (length + 1) + " x i8]* @" + id + ", i32 0, i32 0\n";
        } else {
            buffer += "%" + reg + " = getelementptr inbounds [" + (length + 1) + " x i8], [" + (length + 1) + " x i8]* @" + function + "." + id + ", i32 0, i32 0\n";
        }
        reg++;
        reg++;
    }

    static void declare_i32(String id, boolean global,Object value) {
        if (global) {
            header_text += "@" + id + " = global i32 0\n";
        } else {
            buffer += "%" + id + " = alloca i32\n";
        }
    }

    static void declare_double(String id, boolean global, Object value) {
        if (global) {
            header_text += "@" + id + " = global double 0.0\n";
        } else {
            buffer += "%" + id + " = alloca double\n";
        }
    }


    static void assign_i32(String id,  boolean globalNames,Object value) {
        if (globalNames) {
            buffer += "store i32 " + value+ ", i32* @" + id + "\n";
        } else {
            buffer += "store i32 " + value+ ", i32* %" + id + "\n";
        }
    }

    static void assign_double(String id,  boolean globalNames,Object value) {
        if (globalNames) {
            buffer += "store double " + value + ", double* @" + id + "\n";
        } else {
            buffer += "store double " + value + ", double* %" + id + "\n";
        }
    }

    static void load_i32(String id) {
            buffer += "%" + reg + " = load i32, i32* @" + id + "\n";
            reg++;
    }

    static void load_double(String id) {
        buffer += "%" + reg + " = load double, double* @" + id + "\n";
        reg++;
    }

    static void eq2(String type){

        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp eq i32 %" + (reg - 1) + ", %" + (reg - 2) + "\n";

        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ueq double %" + (reg - 1) + ", %" + (reg - 2) + "\n";
        }
        reg++;
    }

    static void eq1(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp eq i32 %" + (reg - 1) + ", " + value + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ueq double %" + (reg - 1) + ", " + value + "\n";
        }
        reg++;
    }

    static void eq0(String value1, String value2, String type){

        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp eq i32 " + value1 + ", " + value2 + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ueq double " + value1 + ", " + value2 + "\n";
        }
        reg++;
    }

    static void noeq2(String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp ne i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp one double %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        reg++;
    }

    static void noeq1(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp ne i32 %" + (reg - 1) + ", " + value + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp one double %" + (reg - 1) + ", " + value + "\n";
        }
        reg++;
    }

    static void noeq0(String value1, String value2, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp ne i32 " + value1 + ", " + value2 + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp one double " + value1 + ", " + value2 + "\n";
        }
        reg++;
    }

    static void more2(String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sgt i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ogt double %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        reg++;
    }

    static void more1_1(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sgt i32 %" + (reg - 1) + ", " + value + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ogt double %" + (reg - 1) + ", " + value + "\n";
        }
        reg++;
    }

    static void more1_2(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sgt i32 " + value + ", %" + (reg-1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ogt double " + value + ", %" + (reg-1) + "\n";
        }
        reg++;
    }


    static void more0(String value1, String value2, String type) {
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sgt i32 " + value1 + ", " + value2 + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ogt double " + value1 + ", " + value2 + "\n";
        }
        reg++;
    }

    static void less2(String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp slt i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp olt double %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        reg++;
    }

    static void less1_1(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp slt i32 %" + (reg - 1) + ", " + value + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp olt double %" + (reg - 1) + ", " + value + "\n";
        }
        reg++;
    }

    static void less1_2(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp slt i32 " + value + ", %" + (reg - 1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp olt double " + value + ", %" + (reg-1) + "\n";
        }
        reg++;
    }

    static void less0(String value1, String value2, String type) {
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp slt i32 " + value1 + ", " + value2 + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp olt double " + value1 + ", " + value2 + "\n";
        }
        reg++;
    }

    static void moreeq2(String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sge i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp oge double %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        reg++;
    }

    static void moreeq1_1(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sge i32 %" + (reg - 1) + ", " + value + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp oge double %" + (reg - 1) + ", " + value + "\n";
        }
        reg++;
    }

    static void moreeq1_2(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sge i32 " + value + ", %" + (reg-1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp oge double " + value + ", %" + (reg-1) + "\n";
        }
        reg++;
    }

    static void moreeq0(String value1, String value2, String type) {
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sge i32 " + value1 + ", " + value2 + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp oge double " + value1 + ", " + value2 + "\n";
        }
        reg++;
    }

    static void lesseq2(String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sle i32 %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ole double %" + (reg - 2) + ", %" + (reg - 1) + "\n";
        }
        reg++;
    }

    static void lesseq1_1(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sle i32 %" + (reg - 1) + ", " + value + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ole double %" + (reg - 1) + ", " + value + "\n";
        }
        reg++;
    }

    static void lesseq1_2(String value, String type){
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sle i32 " + value + ", %" + (reg-1) + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ole double " + value + ", %" + (reg-1) + "\n";
        }
        reg++;
    }

    static void lesseq0(String value1, String value2, String type) {
        if (type.equals("INTEGER")) {
            buffer += "%" + reg + " = icmp sle i32 " + value1 + ", " + value2 + "\n";
        }
        else if (type.equals("FLOAT")){
            buffer += "%" + reg + " = fcmp ole double " + value1 + ", " + value2 + "\n";
        }
        reg++;
    }

    static void if_start() {
        br++;
        buffer += "br i1 %" + (reg - 1) + ", label %true" + br + ", label %false" + br + "\n";
        buffer += "true" + br + ":\n";
        br_stack.push(br);
    }

    static void if_end() {
        int b = br_stack.pop();
        buffer += "br label %false" + b + "\n";
        buffer += "false" + b + ":\n";
    }

    private static void formatBuffer() {
        String[] lines = buffer.split("\n");
        StringBuilder sb = new StringBuilder();
        sb.append(lines[0]).append("\n");
        for (int i = 1; i < lines.length; i++) {
            sb.append("  ").append(lines[i]).append("\n");
        }
        buffer = sb.toString();
    }

    private static void formatMainText() {
        String[] lines = main_text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append("  ").append(line).append("\n");
        }
        main_text = sb.toString();
    }

    static void while_start() {
        stack_pop = false;
        br++;
        buffer += "br label %while" + br + "\n";
        buffer += "while" + br + ":\n";
        br_loop.push(br);
    }

    static void while_condition(int ref) {
        buffer += "br i1 %" + ref + ", label %true" + br + ", label %false" + br + "\n";
        buffer += "true" + br + ":\n";
        br_stack.push(br);
    }

    static void while_end() {
        int b = br_stack.pop();
        buffer += "br label %while" + b + "\n";
        buffer += "false" + b + ":\n";
        if (!stack_pop) br_loop.pop();
    }
    static void Continue() {
        int b = br_loop.pop();
        buffer += "br label %while" + b + "\n";
        br_loop.push(b);
        reg++;
    }

    static void Break() {
        int b = br_loop.pop();
        reg++;
        stack_pop = true;
        buffer += "br label %false" + b + "\n";
    }

}
