import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FactorialComponent } from './factorial/factorial.component';
import { ArmstrongNumberCheckerComponent } from './armstrong-number-checker/armstrong-number-checker.component';
import { InvertedPyramidComponent } from './inverted-pyramid/inverted-pyramid.component';
import { AtmTransactionComponent } from './atm-transaction/atm-transaction.component';
import { FormsModule } from '@angular/forms';
// import { PrimeNumberCheckerComponent } from './prime-number-checker/prime-number-checker.component';

import { PrimenumberComponent } from './primenumber/primenumber.component';

@NgModule({
  declarations: [
    AppComponent,
    // PrimeNumberCheckerComponent,
    FactorialComponent,
    ArmstrongNumberCheckerComponent,
    InvertedPyramidComponent,
    AtmTransactionComponent,
    PrimenumberComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent],

})
export class AppModule { }
