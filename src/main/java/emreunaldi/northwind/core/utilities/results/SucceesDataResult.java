package emreunaldi.northwind.core.utilities.results;

public class SucceesDataResult<T> extends DataResult<T> {

    public SucceesDataResult() {

        super(null, true);
    }
    public SucceesDataResult(T data) {
        super(data, true);
    }
    public SucceesDataResult(String message) {
        super(null, true, message);
    }
    public SucceesDataResult(T data, String message) {
        super(data, true, message);
    }

}
