declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strps = constant [4 x i8] c"%s\0A\00"
@strsi = constant [3 x i8] c"%d\00"
@strsd = constant [4 x i8] c"%lf\00"

define i32 @funct() nounwind {
  %a = alloca i32
  %b = alloca i32
  %e = alloca i32
  %i = alloca double
  %c = alloca double
  %d = alloca double
  br i1 %true, label %true1, label %false1
  true1:
  store i32 19, i32* % e
  ret i32 0
}
