import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http'; 
import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { GoalComponent } from './goal/goal.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [GoalComponent, CommonModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'finance';
}
