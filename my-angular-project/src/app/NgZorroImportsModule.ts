import {NgModule} from '@angular/core';
//NG ZORRO IMPORTS
import {NzSpinModule} from  'ng-zorro-antd/spin';
import {NzButtonModule} from 'ng-zorro-antd/button';
import {NzFormModule} from 'ng-zorro-antd/form';
import {NzInputModule} from 'ng-zorro-antd/input';
import {NzLayoutModule} from 'ng-zorro-antd/layout';
import { NzMessageModule } from 'ng-zorro-antd/message';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzTimePickerModule } from 'ng-zorro-antd/time-picker';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { NzTableModule } from 'ng-zorro-antd/table';
@NgModule({
  exports: [
        // NG ZORRO IMPORTS
        NzLayoutModule,
        NzInputModule,
        NzFormModule,
        NzButtonModule,
        NzSpinModule,
        NzMessageModule,
        NzSelectModule,
        NzTimePickerModule,
        NzDatePickerModule,
        NzTableModule
  ]
})

export class NgZorroImportsModule{ }