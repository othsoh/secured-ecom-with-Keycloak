import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ProductsComponent} from './ui/products/products.component';
import {CustomersComponent} from './ui/customers/customers.component';
import {HttpClientModule} from "@angular/common/http";


import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import {OrdersComponent} from './ui/orders/orders.component';
import {OrderDetailsComponent} from './ui/order-details/order-details.component';
import {NgOptimizedImage} from "@angular/common";
import {StarRatingModule} from "angular-star-rating";
import {HomeComponent} from "./ui/home/home.component";
import { ProductDetailsComponent } from './ui/product-details/product-details.component';
import { NotFountComponent } from './ui/not-fount/not-fount.component';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'ecom-realm',
        clientId: 'ecom-client-ng'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}


@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    OrdersComponent,
    OrderDetailsComponent,
    HomeComponent,
    ProductDetailsComponent,
    NotFountComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
    NgOptimizedImage,
    StarRatingModule.forRoot(),
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],

    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
