# jhipster web app实验和分析

## 目的

通过分析jhipster生成的webapp来研究angular应用的最佳实践

## 实验列表

- [x] 实验01：基于angular实现增删改查操作
- [x] 实验02：跨域问题
- [x] 实验03：angular整合bootstrap
- [x] 实验04：angular整合awesome字体
- [ ] 实验05：angular实现password功能
- [x] 实验06：angular cli导入ng-jhipster
- [x] 实验07：整合@ng-bootstrap，实现增删改查的可视化界面
- [x] 实验08：angular实现多语言功能
- [x] 实验09：http请求拦截器
- [ ] 实验10：resolve基础用法
- [ ] 实验11：service基础用法
- [ ] 实验12：indext.ts默认索引
- [ ] 实验13：RouterModule的forRoot和forchild
- [ ] 实验14：angular使用图标库
- [ ] 实验15：模态框的使用
- [ ] 实验16：Spring Data Jpa 与 DDD

## 实验

### 实验01：基于angular实现CRUD操作

后端工程：freemud-yapi-demo

前端工程：angular-http-crud

**前端**

ItemComponet

ItemSerivce

实验步骤：

（1）实现ItemService

（2）实现ItemComponent

​	a.实现ItemComponent数据处理逻辑

​	b.实现ItemComponent html template视图逻辑

​	c.查询所有数据、新增数据、删除数据

总结：

对于前端的增删改查操作，需要结合表单进行处理，同时需要通过httpclient访问远程服务。

### 实验02：跨域问题

通过angular cli，可以将angular应用的默认端口4200代理到8080上，实现前后端分离部署。

（1）编写proxy.config.json，内容如下：

```
{
  "/": {
    "target": "http://localhost:8080/",
    "secure": false
  }
}
```

（2）编写常量类app-constants.ts

```
export const SERVER_API_URL = "http://localhost:4200/";
```

（3）修改启动配置，package.json

```
 "start": "ng serve --proxy-config proxy.config.json"
```

（4）启动

```
npm start
```



### 实验03：angular整合ng-bootstrap

实验工程：angular-boostrap-curd

实验过程：

1.使用angular cli工具生成angular-boostrap-curd项目

2.安装ng-bootstrap依赖并配置

a.安装依赖

```
npm install --save @ng-bootstrap/ng-bootstrap
```

b.下载boostrap依赖，并加载boostrap.css文件

```
npm install bootstrap
```

```
@import "~bootstrap/dist/css/bootstrap.css";
```

具体详情参考：https://ng-bootstrap.github.io/#/getting-started>

3.使用ng-component中提供的angular组件

具体各组件的使用，请参考：<https://ng-bootstrap.github.io/#/components/alert/examples>

### 实验04：angular整合awesome字体

步骤：

1.安装依赖  

```
npm install --save @fortawesome/fontawesome-svg-core
npm install --save @fortawesome/free-solid-svg-icons
npm install --save @fortawesome/angular-fontawesome
```

2.添加所需图标

```
import { library } from '@fortawesome/fontawesome-svg-core';
library.add(faCoffee);
```

3.导入依赖

```

```

4.使用图标

```
<fa-icon [icon]="'coffee'"></fa-icon>
```



### 实验05：angular实现password功能



### 实验06：angular cli导入ng-jhipster

angular项目安装jhipster依赖的方法

```
npm install ng-jhipster
```

参考：<https://www.npmjs.com/package/ng-jhipster>

### 实验04：整合@ng-bootstrap，实现增删改查的可视化界面

实验工程：angular-bootstrap-curd 

实验步骤：

1.安装依赖

```
npm install bootstrap
npm install --save @ng-bootstrap/ng-bootstrap
```

​	具体实现细节，请参考：<https://ng-bootstrap.github.io/#/getting-started>

2.引入依赖和配置



（2）实现查询列表视图

（3）实现查询详情视图

（4）实现修改视图

（5）实现删除视图

### 实验08：angular实现多语言功能

angular自带了@ngx-translate组件可以实现多语言功能。

步骤:

1.安装依赖库

```
npm install @ngx-translate/core --save
npm install @ngx-translate/http-loader  --save
```

2.定义方法，加载本地静态资源

```
export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}
```

3.引入模块

在app.module.ts中引入

```
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
```

4.在app.module.ts的imports中加入

```
 TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }
 })
```

### 实验09：http请求拦截器

步骤：

1.引入依赖

```
import {
    HttpInterceptor,
    HttpRequest,
    HttpHandler,
    HttpErrorResponse,
    HttpHeaderResponse,
    HttpResponse,
} from '@angular/common/http';
```

2.编写拦截器实现

```
export class MyInterceptor implements HttpInterceptor {
    constructor (){}
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<
    | HttpHeaderResponse
    | HttpResponse<any> {　
        let req = request.clone({param1:'',param2:''});//这里可以在请求中加参数
        return next.handle(req).pipe( mergeMap((event: any) => {
            // 正常返回，处理具体返回参数
            if (event instanceof HttpResponse && event.status === 200)
                return this.handleData(event);//具体处理请求返回数据
                return of(event);
        }),
        catchError((err: HttpErrorResponse) => this.handleData(err)))
      }
}
```

3.引入

```
import { MyInterceptor } from './myIntercept'
@NgModule({
     ……
     providers: [{ provide: HTTP_INTERCEPTORS, useClass: MyInterceptor, multi:
                     true }]
    ……
})
```

### 实验14：angular使用图标库

步骤：

1.下载依赖

```
npm install @antv/g2 --save
```

2.导入

```
import * as G2 from '@antv/g2';
```

3.使用

app.component.html

```
<div id="c1" ></div>
```

app.component.ts

```typescript
import { Component, OnInit } from '@angular/core';
import * as G2 from '@antv/g2';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  data = {};
  chart ;
  graph;
  constructor() { }
  ngOnInit() {
    this.chartData();
  }
  chartData() {
     this.data = [
      { genre: 'Sports', sold: 275 },
      { genre: 'Strategy', sold: 115 },
      { genre: 'Action', sold: 120 },
      { genre: 'Shooter', sold: 350 },
      { genre: 'Other', sold: 150 }
    ];
     this.chart = new G2.Chart({
      container: 'c1', // 指定图表容器 ID
      width : 600, // 指定图表宽度
      height : 300 // 指定图表高度
    });

    this.chart.source(this.data);
    this.chart.interval().position('genre*sold').color('genre');
    //  渲染图
    this.chart.render();
  }
}
```