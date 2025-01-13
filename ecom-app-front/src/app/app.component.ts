import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "keycloak-angular";
import { KeycloakProfile } from 'keycloak-js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'ecom-app-front';

  public profile!: KeycloakProfile;

  constructor(public keycloakService: KeycloakService) {
  }

  ngOnInit() {
    if (this.keycloakService.isLoggedIn()) {
      this.keycloakService.loadUserProfile().then(profile => {
        this.profile = profile;
      });
    }
  }

  toggleDropdown() {
    const dropdown = document.getElementById('userDropdown1');
    if (dropdown) {
      dropdown.classList.toggle('hidden');
    }
  }

  handleLogout() {
    this.keycloakService.logout(
      window.location.origin
    );
  }

  async handleLogin() {
    await this.keycloakService.login({
      redirectUri: window.location.origin
    });
  }
}
