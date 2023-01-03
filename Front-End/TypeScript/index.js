"use strict";
// console.log('Hello TypeScript !');
// let message = 'Arulmozhi Karunagaran';
// message = 10;
// let message: string = 'Arulmozhi';
// message = 10;
// console.log(message);
// let value: number = 100;
// console.log(value);
// let booleanValue: boolean = true;
// console.log(booleanValue);
// let numbers = [1, 2, 3, 4];
// console.log(numbers);
// numbers.push(5);
// console.log(numbers);
// let myTuple: [number, number, boolean];
// myTuple = [5, 5, true];
// console.log(myTuple);
// const persons = {
//     name: 'Arulmozhi',
//     gender: 'male'
// }
// console.log(persons.name);
// function display(): void {
//     console.log('Display function without return type called');
// }
// display();
// function display(): number {
//     console.log('Display function with return type called');
//     return 100;
// }
// let returnValue = display();
// console.log(returnValue);
// const names: readonly string[] = ['Arulmozhi'];
// names.push('Karunagaran');  // Error because readonly
// const names: { firstName: string, lastName: string, birthdayYear: number } = {
//     firstName: 'Arulmozhi',
//     lastName: 'Karunagaran',
//     birthdayYear: 2002
// };
// console.log(names);
// const names: { firstName: string, lastName: string, birthdayYear : number } = {
// const names: { firstName: string, lastName: string, birthdayYear ?: number } = {
//     firstName: 'Arulmozhi',
//     lastName: 'Karunagaran',
// };
// names.birthdayYear = 2002;
// console.log(names);
// const names: { [index: string]: number } = {};
// names.mobile = 1234567890;
// names.landline = 0987654321;
// // names.other = 'Arulmozhi';  // Error
// console.log(names);
// interface Name {
//     firstName: string,
//     lastName: string
// }
// interface phoneNumber extends Name {
//     phone: number
// }
// const details: phoneNumber = {
//     firstName: 'Arulmozhi',
//     lastName: 'Karunagaran',
//     phone: 1234567890,
// };
// console.log(details);
// function display( input: string | number ) {
//     console.log(`The type of input is ${typeof input}`);
// }
// display('Arulmozhi');
// display(143);
// let value :  unknown = 'Arulmozhi';
// console.log( typeof (value as string) );
// console.log( (value as string).length );
// value = 10;
// console.log( (value as string).length );  //undefined
// console.log( typeof (<number> value) );
class Names {
}
const personOne = new Names();
personOne.name = 'Arulmozhi Karunagaran';
console.log(personOne.name);
