declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strps = constant [4 x i8] c"%s\0A\00"
@strsi = constant [3 x i8] c"%d\00"
@strsd = constant [4 x i8] c"%lf\00"

@a = global i32 0
@b = global i32 0
@e = global i32 0
@i = global double 0.0
@c = global double 0.0
@d = global double 0.0
@str0 = constant[3 x i8] c" \0A\00"
@str1 = constant[3 x i8] c" \0A\00"
define i32 @main() nounwind {
  br label %while1
  while1:
  %1 = load i32, i32* @e
  %2 = icmp slt i32 %1, 9
  br i1 %2, label %true1, label %false1
  true1:
  store i32 11, i32* @e
  store i32 12, i32* @b
  br label %while1
  false1:
  %3 = load i32, i32* @e
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
  %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [3 x i8], [3 x i8]* @str0, i32 0, i32 0))
  %6 = load i32, i32* @b
  %7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %6)
  %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ( [3 x i8], [3 x i8]* @str1, i32 0, i32 0))
  ret i32 0
}
