import { Directive, OnInit, ElementRef, Renderer, Input } from '@angular/core';
import { TranslateService, LangChangeEvent } from '@ngx-translate/core';

@Directive({
  selector: '[myActiveMenu]'
})
export class ActiveMenuDirective implements OnInit {
  @Input() myActiveMenu?: string;

  constructor(private el: ElementRef, private renderer: Renderer, private translateService: TranslateService) {}

  ngOnInit(): void {
    this.translateService.onLangChange.subscribe((event: LangChangeEvent) => {
      this.updateActiveFlag(event.lang);
    });
    this.updateActiveFlag(this.translateService.currentLang);
  }

  updateActiveFlag(selectedLanguage: string): void {
    if (this.myActiveMenu === selectedLanguage) {
      this.renderer.setElementClass(this.el.nativeElement, 'active', true);
    } else {
      this.renderer.setElementClass(this.el.nativeElement, 'active', false);
    }
  }
}
