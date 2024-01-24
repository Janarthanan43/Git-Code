import { PasswordEncryptionPipe } from './password-encryption.pipe';

describe('PasswordEncryptionPipe', () => {
  it('create an instance', () => {
    const pipe = new PasswordEncryptionPipe();
    expect(pipe).toBeTruthy();
  });
});
