
public static final int REQUEST_CONTACT     = 991;
public static final int PERMISSION_CONTACT = 990;

private void openContactList(Activity activity){
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        activity.startActivityForResult(i, DefaultContactPicker.REQUEST_CONTACT);
    }
    
    
public void onActivityResult(Context context, int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = context.getContentResolver().query(contactUri, projection,
                    null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);
            }
            cursor.close();
        }
    }
