# LaundryManagementSystem

洗衣房管理系统

### 1. 开发、环境要求及说明

本项目仍处于初始开发阶段。本文中提到的教程与说明供组员使用。

数据库的结构可能随时发生变更，请组员留意`mysql.sql`的更新。

#### 1.1 本项目主要开发工具和环境：

* Tomcat 9
* Eclipse IDE 2020-09
* OpenJDK 11.0.9
* javac 1.8.0\_272


### 2. GIT简单使用教程

#### 2.1 克隆本项目的远程存储库代码：

```
git clone https://github.com/shouyinji1/LaundryManagementSystem
```

或者（如果网不好可以用这个命令）：

```
git clone --depth=1 https://github.com/shouyinji1/LaundryManagementSystem
```

**注**：`depth`用于指定克隆深度，为1即表示只克隆最近一次commit.

#### 2.2 更新合并本地存储库步骤：

```
git pull    # 将远程存储库中的更改合并到当前分支中
```

**注意**：这个命令一定要没事多敲一敲，特别是在写代码之前。

#### 2.3 提交步骤：

```
git status	# 查看工作目录和暂存区的状态
git add .	# 将修改添加到暂存区
git commit -m "更新日志"	# 将暂存区内容添加到本地仓库中
git pull	# 获取远程存储库的更改，合并到本地分支中
git push	# 将本地分支的更新，推送到远程主机
```

#### 2.4 其它常用命令：

```
git log	# 显示提交日志信息
git diff	# 显示提交和工作树等之间的更改
git stash	# 把所有未提交的修改（包括暂存的和非暂存的）都保存起来,并且将当前代码切换到HEAD commit上.
```

#### 2.5 相关介绍

* [Git基础概念 - 易百教程](https://www.yiibai.com/git/git_basic_concepts.html "Git基础概念 - 易百教程")
* [Git基础和原理 - 易百教程](https://www.yiibai.com/git/git_basic_concepts.html "Git基础和原理 - 易百教程")
* [Git快速入门 - 易百教程](https://www.yiibai.com/git/git-quick-start.html "Git快速入门 - 易百教程")

### 3. 在线Markdown编辑器

* [Markdown在线编辑器 - MdEditor](http://www.mdeditor.com/ "Markdown在线编辑器 - MdEditor")
* [在线markdown编辑器_微信公众号markdown排版工具](https://markdown.com.cn/editor/ "在线markdown编辑器_微信公众号markdown排版工具")
* [MaHua 在线markdown编辑器](http://mahua.jser.me/ "MaHua 在线markdown编辑器")

Eclipse IDE也支持Markdown的编辑及预览。

### 4. 其它类似项目参考
* [lvpengyue/washRoom](https://github.com/lvpengyue/washRoom "lvpengyue/washRoom")
