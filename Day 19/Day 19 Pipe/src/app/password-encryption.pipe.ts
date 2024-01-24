
import { Pipe, PipeTransform } from '@angular/core';
 
@Pipe({

  name: 'passwordEncryption'

})

export class PasswordEncryptionPipe implements PipeTransform {

  transform(password: string): string {

    // Implement your encryption algorithm (e.g., Base64 encoding)

    return this.encodeBase64(password);

  }
 
  private encodeBase64(input: string): string {

    return btoa(input);

  }

}
