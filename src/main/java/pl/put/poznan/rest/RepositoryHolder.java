package pl.put.poznan.rest;

public final class RepositoryHolder {
    private BuildingRepository buildingRepository;
    private final static RepositoryHolder INSTANCE = new RepositoryHolder();

    private RepositoryHolder() {}

    public static RepositoryHolder getInstance() {
        return INSTANCE;
    }

    public void setBuildingRepository(BuildingRepository repo) {
        this.buildingRepository = repo;
    }

    public BuildingRepository getBuildingRepository() {
        return this.buildingRepository;
    }
}
