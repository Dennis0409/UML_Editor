# 定义变量
JAVAC = javac
SRC_DIRS = ./Mode ./Obj ./frame
JAVA_FILES = $(foreach dir,$(SRC_DIRS),$(wildcard $(dir)/*.java))
CLASS_FILES = $(JAVA_FILES:.java=.class)

# 默认目标
all: $(CLASS_FILES)

# 编译 .java 文件为 .class 文件
%.class: %.java
	$(JAVAC) $<

# 清除生成的 .class 文件
clean:
	rm -f $(CLASS_FILES)

