declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strps = constant [4 x i8] c"%s\0A\00"
@strsi = constant [3 x i8] c"%d\00"
@strsd = constant [4 x i8] c"%lf\00"

@x = global double 0.0
@squ = global double 0.0
@str0 = constant[3 x i8] c" \0A\00"
@str1 = constant[3 x i8] c" \0A\00"
define i32 @main() nounwind {
  store double 7.0, double* @x
  br label %while1
  while1:
  br i1 %0, label %true1, label %false1
  true1:
  store double 8.0, double* @x
  store double 20.0, double* @squ
  store double 9.0, double* @x
  store double 200.0, double* @squ
  br label %while1
  false1:
  %1 = load double, double* @x
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %1)
  %3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [3 x i8], [3 x i8]* @str0, i32 0, i32 0))
  %4 = load double, double* @squ
  %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %4)
  %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [3 x i8], [3 x i8]* @str1, i32 0, i32 0))
  ret i32 0
}
