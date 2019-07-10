import { Component, ElementRef, AfterViewInit, ViewChild, Renderer, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name: string = 'tanjie';
  @ViewChild('greet', { static: false })
  greetDiv: ElementRef;

  constructor(private renderer: Renderer2, private elementRef: ElementRef) {
  }


  ngAfterViewInit() { // 模板中的元素已创建完成
    this.renderer.setStyle(this.greetDiv.nativeElement, 'backgroundColor', 'red');
  }
}
