package guru.springframework.repositories;

import guru.springframework.demain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.UUID;


public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {



}
