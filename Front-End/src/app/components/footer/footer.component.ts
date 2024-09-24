import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss'
})
export class FooterComponent implements OnInit {
    nome = "Carlos"

    constructor() {
        console.log('FooterComponent')
    }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
}
