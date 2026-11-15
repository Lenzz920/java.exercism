import java.util.HashMap;
import java.util.Map;

public class RebuildDialingCodes {
  private final Map<Integer, String> dialingCodes = new HashMap<>();

  public Map<Integer, String> getCodes() {
    return Map.copyOf(dialingCodes);
  }

  public void setDialingCode(int code, String country) {
    dialingCodes.put(code, country);
  }

  public String getCountry(int code) {
    return dialingCodes.get(code);
  }

  public void addNewDialingCode(int code, String country) {
    if (!dialingCodes.containsKey(code) && !dialingCodes.containsValue(country)) {
      dialingCodes.put(code, country);
    }
  }

  public Integer findDialingCode(String country) {
    for (Integer code : dialingCodes.keySet()) {
      if (dialingCodes.get(code).equals(country)) {
        return code;
      }
    }
    return null;
  }

  public void updateCountryDialingCode(int code, String country) {
    Integer existingCode = findDialingCode(country);

    if (existingCode != null && !dialingCodes.containsKey(code)) {
      dialingCodes.remove(existingCode);
      setDialingCode(code, country);
    }
  }
}
