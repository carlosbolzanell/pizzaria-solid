import { Component } from '@angular/core';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { iconoirUser } from '@ng-icons/iconoir';
import { tablerPizza } from '@ng-icons/tabler-icons';
import {featherShoppingCart} from '@ng-icons/feather-icons';
import { Router } from '@angular/router';
 
@Component({
  selector: 'app-header',
  standalone: true,
  imports: [NgIconComponent],
  viewProviders: [provideIcons({ iconoirUser, tablerPizza, featherShoppingCart })],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  constructor(private router: Router) {
  }

  navegar(rota: string){
    this.router.navigate([rota]);
  }

}
