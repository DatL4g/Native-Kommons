package dev.datlag.kommons


data object Brazil : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BRA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(76)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(55)
}