#FROM ubuntu:latest
#ENTRYPOINT ["top", "-b"]
#docker build -f Dockerfile -t jenkins-xujs/1.0 .

#FROM ubuntu:latest
# 使用官方的 Jenkins 镜像
FROM jenkins/jenkins:lts
LABEL authors="BigStar"

# 切换到 root 用户
USER root

# 设置时区为 Asia/Shanghai，可以根据需要修改
ENV TZ=Asia/Shanghai

# 更换源为阿里云源（可选，根据实际情况）
RUN echo "deb http://mirrors.aliyun.com/debian/ buster main" > /etc/apt/sources.list

# 更新并安装 tzdata，用于设置时区
RUN apt-get update && \
    apt-get install -y tzdata
# 安装 wget、ping、tar、unzip、zip、tree、less、vi、vim（可选，根据实际情况）
RUN apt-get install -y wget
RUN apt-get install -y curl
#ping
RUN apt-get install -y inetutils-ping
RUN apt-get install -y tar
RUN apt-get install -y unzip
RUN apt-get install -y zip
RUN apt-get install -y tree
RUN apt-get install -y less
#vi
RUN apt-get install -y nvi
RUN apt-get install -y vim
RUN rm -rf /var/lib/apt/lists/*


# 设置时区
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 切换回 jenkins 用户
USER jenkins

# 添加额外的配置或插件安装（根据需要）

# 启动 Jenkins
#CMD ["java", "-jar", "/usr/share/jenkins/jenkins.war"]
ENTRYPOINT ["java", "-jar", "/usr/share/jenkins/jenkins.war"]
