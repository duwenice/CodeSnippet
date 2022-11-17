# CodeSnippet
写代码都是crud，所以经常有些代码块需要保存的需求，之前一般是本地的markdown记录。前两天突然想到可以通过Idea的插件自动上传到语雀的知识库，于是就有了这个插件。

## 插件配置
由于插件需要把代码块上传到语雀，所以需要一些语雀的配置。
![image.png](https://cdn.nlark.com/yuque/0/2022/png/205676/1668685705870-ec526b10-a26e-4b93-adaa-31de28b45d02.png#averageHue=%23232629&clientId=u5b893046-1bcd-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=752&id=u70ac3c2d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1504&originWidth=1956&originalType=binary&ratio=1&rotation=0&showTitle=false&size=248828&status=done&style=none&taskId=u3f130ce2-d376-41c4-85cb-6934a8969ea&title=&width=978)
插件的配置在tools目录下，需要两个配置：

- 语雀的Token(在账户设置里面新建一个Token即可)![image.png](https://cdn.nlark.com/yuque/0/2022/png/205676/1668685793628-7799a4dc-c0df-476a-b7bc-6a6e54582129.png#averageHue=%23e5e5e5&clientId=u5b893046-1bcd-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=579&id=u6296b00a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1158&originWidth=2116&originalType=binary&ratio=1&rotation=0&showTitle=false&size=117916&status=done&style=none&taskId=ue42f88f5-d621-4807-ae58-73df18d150b&title=&width=1058)
- 上传到语雀对应知识库的路径

![image.png](https://cdn.nlark.com/yuque/0/2022/png/205676/1668685889015-552b361f-b629-4ff0-bcb8-831cf27aea1e.png#averageHue=%23eef2f0&clientId=u5b893046-1bcd-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=658&id=u7975c9ef&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1316&originWidth=3092&originalType=binary&ratio=1&rotation=0&showTitle=false&size=410386&status=done&style=none&taskId=udee3d224-983d-4418-a699-bb0a8fe2888&title=&width=1546)
语雀的知识库路径获取方式：打开对应的知识库，yuque.com/ 后面的部分就是，比如上图中的知识库路径就是duwencloud/codesnippet，也可以在知识库的设置里面自定义。

## 使用
配置好之后，使用就很简单了。

1. 选中代码块

![image.png](https://cdn.nlark.com/yuque/0/2022/png/205676/1668686048935-9c0464e9-687d-42cf-bd2e-35876351860a.png#averageHue=%23232e4a&clientId=u5b893046-1bcd-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=389&id=u87bd9bc1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=778&originWidth=1642&originalType=binary&ratio=1&rotation=0&showTitle=false&size=284029&status=done&style=none&taskId=u1a6af6f7-57a6-4695-82cc-3e85e97b06f&title=&width=821)

2. 编辑备注![image.png](https://cdn.nlark.com/yuque/0/2022/png/205676/1668686126864-fa024b17-c00c-4d40-af86-dbbd310caad6.png#averageHue=%231f2c4f&clientId=u5b893046-1bcd-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=427&id=ua20aedc2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=854&originWidth=1812&originalType=binary&ratio=1&rotation=0&showTitle=false&size=391202&status=done&style=none&taskId=uf67e0db2-9784-48d9-b2bf-80c26f1008f&title=&width=906)
3. 确认上传然后就会在语雀对应的知识库下生成一篇当天的文档了。![image.png](https://cdn.nlark.com/yuque/0/2022/png/205676/1668686166357-7805ce00-d978-425f-b420-fe7b953ddabc.png#averageHue=%23e7e7e7&clientId=u5b893046-1bcd-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=607&id=ub2574673&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1214&originWidth=2916&originalType=binary&ratio=1&rotation=0&showTitle=false&size=285461&status=done&style=none&taskId=ue6114802-6554-4e0f-9d1c-c881a002eb6&title=&width=1458)
