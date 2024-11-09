export class FormationSchool {
  school_name!:string;
  formation_name!:string;
  city!:string;
  list_alumni?:String[];

  constructor(school_name: string, formation_name: string, city:string, list_alumni: String[]){
    this.school_name= school_name;
    this.formation_name=formation_name;
    this.city=city;
    this.list_alumni=list_alumni;
  }
}