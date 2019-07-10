import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { ExecisePlanComponent } from '../execise-plan/execise-plan.component';

interface ExecisePlan {
  beginTime: string;
  endTime: string;
  group: number;
}

interface ExeciseEntry {
  name: string,
  target: number,
  isFinished: boolean,
  entryGroup: any[]
}


const Plan: ExecisePlan = {
  beginTime: "2019-07-02 10:42:00",
  endTime: "2019-07-02 11:42:00",
  group: 2
}

const Entrys: ExeciseEntry[] = [
  {
    name: "俯卧撑",
    target: 80,
    isFinished: true,
    entryGroup: [
      {
        index: 0,
        number: 40
      },
      {
        index: 1,
        number: 40
      }
    ]
  },
  {
    name: "臂力器",
    target: 60,
    isFinished: true,
    entryGroup: [
      {
        index: 0,
        number: 30
      },
      {
        index: 1,
        number: 30
      }
    ]
  }
]


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  closeResult: string;
  plan = Plan;
  entrys = Entrys;
  group = [
    {
      index: 1,
      name: "第一组"
    },
    {
      index: 2,
      name: "第二组"
    }
  ]

  execiseProject;
  execiseTarget;

  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  save() {
    console.log(this.execiseProject, this.execiseTarget)
    this.modalService.dismissAll();
    let newEntry: ExeciseEntry = {
      name: this.execiseProject,
      target: this.execiseTarget,
      isFinished: true,
      entryGroup: [
        {
          index: 0,
          number: 0
        },
        {
          index: 1,
          number: 0
        }
      ]
    };

    this.entrys.push(newEntry);

  }

}
